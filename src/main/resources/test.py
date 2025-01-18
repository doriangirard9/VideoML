# Code generated from a VideoML scrip
# Video name: stacking

from moviepy import *

font = "./font/font.ttf"

video_width = 1280
video_height = 720

final_clip_list = []
clip1 = VideoFileClip("second_clip.mp4").with_start(0)
clip1 = clip1.with_position(('center', 'center'))
final_clip_list.append(clip1)
effect = VideoFileClip("explosion.mp4").with_start(clip1.start)
effect = effect.with_position(('center', 'center'))
effect = effect.resized(2.0)
effect = effect.resized(1.0)
effect = effect.with_effects([vfx.MaskColor(color=(0, 255, 8), threshold=150, stiffness=5)])
final_clip_list.append(effect)
