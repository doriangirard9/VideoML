# Code generated from a VideoML script
# Video name: Holidays

from moviepy import *

font = "./font/font.ttf"

first_clip = VideoFileClip("first_clip.mp4")
second_clip = VideoFileClip("second_clip.mp4")

video_width = 1280
video_height = 720

final_clips = []
caption1 = (TextClip(text="Paris, 20/12/2024", font=font, font_size=48, color='white', bg_color='black').with_duration(10).resized(width=video_width, height=video_height).with_position(('center', 'center')).with_start(0))
final_clips.append(caption1)
caption2 = (TextClip(text="Thanks for watching !", font=font, font_size=48, color='white', bg_color='black').with_duration(15).resized(width=video_width, height=video_height).with_position(('center', 'center')).with_start(0))
final_clips.append(caption2)
first_clip = first_clip.with_start(15)
final_clips.append(first_clip)
second_clip = second_clip.with_start(first_clip.end)
final_clips.append(second_clip)
final_clip = CompositeVideoClip(final_clips)
final_clip.write_videofile("output.mp4", codec="libx264")
