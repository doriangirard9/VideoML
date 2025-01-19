# Code generated from a VideoML scrip
# Video name: Work

from moviepy import *

font = "./font/font.ttf"

video_width = 1280
video_height = 720

final_clip_list = []
AUTO_GENERATED_CLIP_0 = TextClip(text="intro", font=font, font_size=48, color='white').with_start(0).with_duration(10)
AUTO_GENERATED_CLIP_0 = AUTO_GENERATED_CLIP_0.with_position(('center', 'center'))
final_clip_list.append(AUTO_GENERATED_CLIP_0)
clip1a = VideoFileClip("first_clip.mov").subclipped(10, 30)
clip1a = clip1a.with_start(AUTO_GENERATED_CLIP_0.end)
clip1a = clip1a.with_position(('center', 'center'))
final_clip_list.append(clip1a)
clip1b = VideoFileClip("clip2.mp4").subclipped(10, 55)
clip1b = clip1b.with_start(clip1a.end)
clip1b = clip1b.with_position(('center', 'center'))
final_clip_list.append(clip1b)
AUTO_GENERATED_CLIP_1 = TextClip(text="s1", font=font, font_size=48, color='white').with_start(clip1a.start + 0).with_duration(10)
AUTO_GENERATED_CLIP_1 = AUTO_GENERATED_CLIP_1.with_position(('center', 'center'))
final_clip_list.append(AUTO_GENERATED_CLIP_1)
AUTO_GENERATED_CLIP_2 = TextClip(text="s2", font=font, font_size=48, color='white').with_start(clip1a.start + 10).with_duration(10)
AUTO_GENERATED_CLIP_2 = AUTO_GENERATED_CLIP_2.with_position(('center', 'center'))
final_clip_list.append(AUTO_GENERATED_CLIP_2)
AUTO_GENERATED_CLIP_3 = TextClip(text="s3", font=font, font_size=48, color='white').with_start(clip1a.start + 15).with_duration(15)
AUTO_GENERATED_CLIP_3 = AUTO_GENERATED_CLIP_3.with_position(('center', 'center'))
final_clip_list.append(AUTO_GENERATED_CLIP_3)
AUTO_GENERATED_CLIP_4 = TextClip(text="thanks", font=font, font_size=48, color='white').with_start(clip1b.end).with_duration(10)
AUTO_GENERATED_CLIP_4 = AUTO_GENERATED_CLIP_4.with_position(('center', 'center'))
final_clip_list.append(AUTO_GENERATED_CLIP_4)
final_clip = CompositeVideoClip(final_clip_list, size=(video_width, video_height))
final_clip.write_videofile("Work.mp4", codec="libx264", fps=24)
