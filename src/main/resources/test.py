# Code generated from a VideoML scrip
# Video name: test

from moviepy import *

font = "./font/font.ttf"

video_width = 1280
video_height = 720

final_clip_list = []
clip1 = VideoFileClip("first_clip.mp4").subclipped(0, 5).with_start(0)
final_clip_list.append(clip1)
clip2 = VideoFileClip("first_clip.mp4").subclipped(5, 10).with_start(clip1.start)
final_clip_list.append(clip2)
final_clip = CompositeVideoClip(final_clip_list, size=(video_width, video_height))
final_clip.write_videofile("output.mp4", codec="libx264")
