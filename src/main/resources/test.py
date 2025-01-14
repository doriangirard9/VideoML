# Code generated from a VideoML scrip
# Video name: stacking

from moviepy import *

font = "./font/font.ttf"

video_width = 1280
video_height = 720

final_clip_list = []
clip1 = VideoFileClip("second_clip.mp4").subclipped(0, 5).with_start(0)
clip1 = clip1.with_position(('center', 'center'))
final_clip_list.append(clip1)
clip2 = VideoFileClip("second_clip.mp4").with_start(clip1.end)
clip2 = clip2.with_position(('center', 'center'))
clip2 = clip2.with_effects([vfx.MultiplySpeed(0.5)])
final_clip_list.append(clip2)
clip2.preview(fps=12)
