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

**Examples**
```
# Caption on a black screen
caption "some text"

# Caption on a video clip
caption "some text" on video_clip
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
add "video1" and "video2" and ...
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
stack "name1" on "name2"

# Stack a video clip on another at a specific position
stack "name1" on "name2" at position

# Stack a video clip on another with a new scale
stack "name1" on "name2" scale newScale
```

## Timings
only for texts and images
```
# Duration
... for 10s

# Absolute time
... from 2s to 10s

# Offset time
... 3s after some_clip
... 3s before some_clip
```

## Naming
Naming a clip allows you to reference it later in the project.
```
# Named clip
... as some_name
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
green screen some_clip threshold 0.5
```

---

## Audio Clips
You can overlay audio clips onto your videos using the `overlay` keyword.

**Parameters**
- audioFile: `string` = Path to the audio file (.mp3 or .wav).
- clipName: `string` or `VideoClip`
- timestamp: `TIME`

**Examples**
```
# Overlay audio at a specific timestamp
overlay "audio.mp3" on some_clip at 00:00:10
```

---

## Audio Effects

### Adjust Volume
Adjust the volume of an audio file using the `adjust volume` keyword.

**Parameters**
- audioFile: `string`
- volume: `int`

**Examples**
```
# Set volume to 80
adjust volume of "audio.mp3" to 80
```
