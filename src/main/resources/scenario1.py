# Code generated from a VideoML script
# Video name: Holidays

from moviepy import *

font = "./font/font.ttf"

video_width = 1280
video_height = 720

final_clips = []
caption1 = (TextClip(text="Paris, 20/12/2024", font=font, font_size=48, color='white').with_duration(10).with_position('center').with_start(0))
final_clips.append(caption1)
first_clip = VideoFileClip("first_clip.mov").with_start(caption1.end)
final_clips.append(first_clip)
second_clip = VideoFileClip("second_clip.mp4").with_start(first_clip.end)
final_clips.append(second_clip)
caption2 = (TextClip(text="Thanks for watching !", font=font, font_size=48, color='white').with_duration(15).with_position('center').with_start(second_clip.end))
final_clips.append(caption2)
final_clip = CompositeVideoClip(final_clips, size=(video_width, video_height))
final_clip.write_videofile("output.mp4", codec="libx264")
