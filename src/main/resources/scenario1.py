# Code generated from a VideoML scrip
# Video name: Holidays

from moviepy import *

font = "./font/font.ttf"

video_width = 1280
video_height = 720

final_clip_list = []
AUTO_GENERATED_CLIP_0 = TextClip(text="Paris, 20/12/2024", font=font, font_size=48, color='white').with_start(0).with_duration(10)
AUTO_GENERATED_CLIP_0 = AUTO_GENERATED_CLIP_0.with_position(('center', 'center'))
final_clip_list.append(AUTO_GENERATED_CLIP_0)
AUTO_GENERATED_CLIP_1 = VideoFileClip("first_clip.mov")
AUTO_GENERATED_CLIP_1 = AUTO_GENERATED_CLIP_1.with_start(AUTO_GENERATED_CLIP_0.end)
AUTO_GENERATED_CLIP_1 = AUTO_GENERATED_CLIP_1.with_position(('center', 'center'))
final_clip_list.append(AUTO_GENERATED_CLIP_1)
AUTO_GENERATED_CLIP_2 = VideoFileClip("second_clip.mp4")
AUTO_GENERATED_CLIP_2 = AUTO_GENERATED_CLIP_2.with_start(AUTO_GENERATED_CLIP_1.end)
AUTO_GENERATED_CLIP_2 = AUTO_GENERATED_CLIP_2.with_position(('center', 'center'))
final_clip_list.append(AUTO_GENERATED_CLIP_2)
AUTO_GENERATED_CLIP_3 = TextClip(text="Thanks for watching !", font=font, font_size=48, color='white').with_start(AUTO_GENERATED_CLIP_2.end).with_duration(15)
AUTO_GENERATED_CLIP_3 = AUTO_GENERATED_CLIP_3.with_position(('center', 'center'))
final_clip_list.append(AUTO_GENERATED_CLIP_3)
final_clip = CompositeVideoClip(final_clip_list, size=(video_width, video_height))
final_clip.write_videofile("Holidays.mp4", codec="libx264", fps=24)
