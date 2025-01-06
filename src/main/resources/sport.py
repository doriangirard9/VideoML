# Code generated from a VideoML script
# Video name: Sport

from moviepy import *

font = "./font/font.ttf"

video_width = 1280
video_height = 720

final_clips = []
background = VideoFileClip("first_clip.mp4").with_start(0)
background = background.resized(1.00)
background = background.with_position(("center", "center"))
final_clips.append(background)
foreground = VideoFileClip("first_clip.mp4").with_start(background.start)
foreground = foreground.resized(0.20)
foreground = foreground.with_position(("left", "bottom"))
final_clips.append(foreground)
final_clip = CompositeVideoClip(final_clips, size=(video_width, video_height))
final_clip.write_videofile("output.mp4", codec="libx264")
