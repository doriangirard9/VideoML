# Code generated from a VideoML scrip
# Video name: stacking

from moviepy import *

font = "./font/font.ttf"

video_width = 1280
video_height = 720

final_clip_list = []
sub_clip_list = []
sub_clip2_list = []
clip1 = VideoFileClip("second_clip.mp4").subclipped(0, 1).with_start(0)
clip1 = clip1.with_position(('center', 'center'))
clip1 = clip1.with_effects([vfx.Freeze(1, 4)])
final_clip_list.append(clip1)
clip2 = VideoFileClip("second_clip.mp4").with_start(clip1.start)
clip2 = clip2.with_position(('center', 'center'))
sub_clip2_list.append(clip2)
clip3 = VideoFileClip("second_clip.mp4").with_start(clip2.start)
clip3 = clip3.with_position(('center', 'center'))
sub_clip_list.append(clip3)
clip4 = VideoFileClip("second_clip.mp4").with_start(clip3.start)
clip4 = clip4.with_position(('left', 'bottom'))
clip4 = clip4.resized(0.5)
sub_clip_list.append(clip4)
sub_clip = CompositeVideoClip(sub_clip_list, size=(video_width, video_height))
sub_clip = sub_clip.with_position(('left', 'bottom'))
sub_clip = sub_clip.resized(0.5)
sub_clip2_list.append(sub_clip)
sub_clip2 = CompositeVideoClip(sub_clip2_list, size=(video_width, video_height))
sub_clip2 = sub_clip2.with_position(('left', 'bottom'))
sub_clip2 = sub_clip2.resized(0.5)
final_clip_list.append(sub_clip2)
final_clip = CompositeVideoClip(final_clip_list, size=(video_width, video_height))
final_clip.write_videofile("stacking.mp4", codec="libx264", fps=12)
