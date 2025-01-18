# Documentation

## Table of contents
- [Project](#project)
- [Captions](#captions)
- [Video clips](#video-clips)
    - [Adding a video clip](#adding-a-video-clip)
    - [Cutting a video clip](#cutting-a-video-clip)
    - [Concatenating video clips](#concatenating-video-clips)
    - [Stacking video clips](#stacking-video-clips)
- [Video effects](#video-effects)
- [Audio clips](#audio-clips)
- [Audio effects](#audio-effects)

## Project
You can define your project name using the `Project` keyword.

**Parameters**
- name : `string`
- fps ?: `int`
- resolution ?: `(int, int)`

**Examples**
```
# Simple project name
Project example_video

# Full example
Project example_video at 24fps resolution 1280 x 720
```

## Captions
You can add captions to your clips using the `caption` keyword.

Note that if you don't specify a clip, the caption will be added on a black screen.

**Parameters**
- text : `string`
- clip ?: `VideoClip`
- target ?: `VideoClip` = This will tie the caption to the clip
- duration ?: `time` = The duration of the caption
- offset ?: `time` = The offset of the caption
- position ?: `(string, string)` = The position of the image on the screen

**Examples**
```
# Caption on a black screen for 10s
caption "some text" for 10s

# Caption on a video clip
caption "some text" on video_clip

# Caption on a video clip with an offset
caption "some text" on video_clip wait 2s

# Caption on a video clip at a specific position
caption "some text" on video_clip at (left, bottom)

# Full example
caption "some text" on video_clip wait 2s for 5s at (left, bottom)
```

## Image clips

You can add image clips to your project using the `image` keyword.

**Parameters**
- name : `string` = The path to the image file (.png or .jpg)
- clip ?: `VideoClip`
- target ?: `VideoClip` = This will tie the image to the clip
- duration ?: `time` = The duration of the image
- offset ?: `time` = The offset of the image
- position ?: `(string, string)` = The position of the image on the screen

**Examples**
```
# Image on a black screen for 10s
image "image.png" for 10s

# Image on a video clip
image "image.png" on video_clip

# Image on a video clip with an offset
image "image.png" on video_clip wait 2s

# Image on a video clip at a specific position
image "image.png" on video_clip at (left, bottom)

# Full example
image "image.png" on video_clip wait 2s for 5s at (left, bottom)
```

## Video clips

### Adding a video clip
You can add video clips to your project using the `add` keyword.

Note that the order of the video clips in the project is the order in which they are added.

**Parameters**
- name : `string` = The path to the video file (.mp4 or .mov)

**Returns** `void`

**Examples**
```
# Adding multiple video clips
add "video1.mp4" and "video2.mp4" and ...

# Adding and naming a video clip
add "video1.mp4" as video_clip1

# Full example
add "video1.mp4" as video_clip1 and "video2.mp4" as video_clip2
```

### Cutting a video clip
You can cut a video clip using the `cut` keyword.

**Parameters**
- name : `string` or `VideoClip` = The name can be a path to a file or a video clip object
- start : `int` + `'s'`
- end : `int` + `'s'`

**Examples**
```
cut video_clip1 from 10s to 15s

# Full example
cut video_clip1 from 10s to 15s as new_clip
```

### Concatenating video clips
You can concatenate video clips using the `combine` keyword. This allows you to treat multiple video clips as a single one and apply effects to the entire sequence for example.

Note that this instruction does not add video clips to the timeline.

**Parameters**
- clipName : `string` or `VideoClip` = The name can be a path to a file or a video clip object
- resultName : `string`

**Examples**
```
combine video_clip1 and video_clip2 and ... as clips
```

### Stacking video clips
You can stack video clips using the `stack` keyword.

**Parameters**
- name : `string` or `VideoClip`
- target : `string` or `VideoClip`

**Examples**
```
# Stack a video clip on another
stack "name1.mp4" on "name2.mp4"

# Stack a video clip on another at a specific position
stack "name1.mp4" on "name2.mp4" at (left, bottom)

# Stack a video clip on another with a new scale
stack "name1.mp4" on "name2.mp4" scale 0.5

# Full example
stack "name1.mp4" on "name2.mp4" at (left, bottom) scale 0.5
```

## Video Effects
You can apply various effects to your video clips using the provided keywords.

### Cropping
You can crop a video clip using the `crop` keyword.

**Parameters**
- clipName: `string` or `VideoClip`
- options:
  - `all`: Crop all sides equally by a percentage.
  - `leftRight` and `topBottom`: Crop left-right and top-bottom by different percentages.
  - Individual sides (`left`, `top`, `right`, `bottom`): Crop specific sides by a percentage.

**Examples**
```
# Crop all sides by 10%
crop 10% of some_clip

# Crop specific sides
crop left 5% top 10% right 5% bottom 10% of some_clip
```

### Freezing
You can freeze a frame in a video clip using the `freeze` keyword.

**Parameters**
- clipName: `string` or `VideoClip`
- start: `time`
- duration: `time`

**Examples**
```
# Freeze a frame at 5s for 3s
freeze some_clip at 5s for 3s
```

### Resizing
Resize a video clip using the `resize` keyword.

**Parameters**
- clipName: `string` or `VideoClip`
- size:
  - `dimensions`: Width and height in pixels.
  - `percentage`: Resize by a percentage.

**Examples**
```
# Resize to specific dimensions
resize some_clip to 1920x1080

# Resize by percentage
resize some_clip to 50%
```

### Rotating
You can rotate a video clip using the `rotate` keyword.

**Parameters**
- clipName: `string` or `VideoClip`
- degrees: `int`

**Examples**
```
# Rotate a clip by 90 degrees
rotate some_clip by 90
```

### Speed Adjustments
You can adjust the speed of a clip using `slow` or `accelerate`.

**Parameters**
- clipName: `string` or `VideoClip`
- percentage: `float`

**Examples**
```
# Slow down a clip by 50%
slow some_clip by 50%

# Speed up a clip by 150%
accelerate some_clip by 150%
```

### Transitions
Add transitions between clips using the `transition` keyword.

**Parameters**
- type: `fadeIn`, `fadeOut`, `crossFadeIn`, `crossFadeOut`
- clipName: `string` or `VideoClip`
- duration: `time`

**Examples**
```
# Fade in transition
transition fadeIn on some_clip duration 2s
```

### Green Screen
Apply a green screen effect using the `green screen` keyword.

**Parameters**
- clipName: `string` or `VideoClip`
- threshold: `float` (optional)

**Examples**
```
# Apply green screen effect
green screen some_clip threshold 150
```

---

## Audio Clips

## Concatenating audio clips
Concatenate audio clips using the same keyword as for video clips `combine`. This helps to put together
multiple audio chunks together and apply effects on it.

**Parameters**
- audioName : `string` or `AudioClip` = The name can be a path to a file or an AudioClip object
- resultVariable : `string`

**Examples** 
```
combine "audio1.mp3" and "audio2.mp3" as combined_result
```

---

## Audio Overlay

You can overlay audio clips onto your videos using the `overlay` keyword.
Two scenarios are possible:
  - with timestamp provided: 1)For the audio cut 2) Where exactly the audio needs to be placed on video 
  - without timestamp: the audio is placed from the start of the video till the end (if it is longer than the total time of the video, it will not be overlayed on the next video; if it is smaller than the total time of the video - it will stops after reaching its finish)

**Parameters**
- audioFile: `string` = Path to the audio file (.mp3 or .wav).
- targetClipName: `string` or `VideoClip`
- timestamp: `TIME`

**Examples**
```
# Overlay audio at a specific timestamp positionned at some time in the video
overlay "audio.mp3" fromAudio 0s forAudio 10s on some_clip fromVideo 3s forVideo 10s

# Overlay audio without timestamps
overlay audio on some_clip
```

---

## Audio Effects

### Adjust Volume
Adjust the volume of an audio file using the `adjust volume` keyword.

**Parameters**
- audioFile: `string`
- volume: `int` + % (absolute position of the volume)

**Examples**
```
# Set volume to 80
adjust volume of "audio.mp3" to 80%
```
