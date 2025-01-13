import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.progress.PerformInBackgroundOption
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx
import com.intellij.openapi.vfs.VirtualFile
import static liveplugin.PluginUtil.*

if (isIdeStartup) return

registerAction(
        id = "Generate video",
        keyStroke = "control shift G",
        actionGroupId = "ProjectViewPopupMenu", { AnActionEvent event ->

    def project = event.project
    if (project == null) {
        show("No project detected.")
        return
    }

    VirtualFile file = null
    if (event.inputEvent instanceof java.awt.event.MouseEvent) {
        def dataContext = event.getDataContext()
        file = CommonDataKeys.VIRTUAL_FILE.getData(dataContext)
    } else if (event.inputEvent instanceof java.awt.event.KeyEvent) {
        def editorManager = FileEditorManagerEx.getInstanceEx(project)
        file = editorManager.currentFile
    }

    if (file == null) {
        show("No file selected or open.")
        return
    }

    def docManager = FileDocumentManager.instance
    def document = docManager.getDocument(file)
    if (document != null) docManager.saveDocument(document)

    if (file.extension != "videoml") {
        show("Not a videoml file: ${file.path}")
        return
    }

    show("File: ${file.path}")

    doInBackground("Generate...", false, PerformInBackgroundOption.ALWAYS_BACKGROUND, {
        try {
            def fileNameWithoutExtension = file.nameWithoutExtension
            def directory = new File(file.parent.parent.parent.parent.path)
            def command = ["bash", "run.sh", fileNameWithoutExtension]

            def process = new ProcessBuilder(command)
                    .directory(directory)
                    .start()

            int exitCode = process.waitFor()
            def output = process.inputStream.text
            showInConsole("Output: ${output}", project)
            if (exitCode == 0) {
                show("Command executed successfully for: ${file.name}")
            } else {
                def errorOutput = process.errorStream.text
                show("Error occurred: ${errorOutput}")
            }
        } catch (Exception e) {
            show("An error occurred: ${e.message}")
        }
    })
})

show("Loaded generate video plugin")
