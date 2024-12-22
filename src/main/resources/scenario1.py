# Code generated from a VideoML script
# Video name: Holidays

from moviepy import *

font = "./font/font.ttf"

clip1 = VideoFileClip("first_clip.mp4")
clip2 = VideoFileClip("second_clip.mp4")

combined_clip = concatenate_videoclips([clip1, clip2])

video_width, video_height = combined_clip.size

caption1 = (TextClip(text="Paris, 20/12/2024", font=font, font_size=48, color='white', bg_color='black').with_duration(10).resized(width=video_width).with_position('center'))
caption2 = (TextClip(text="Thanks for watching !", font=font, font_size=48, color='white', bg_color='black').with_duration(15).resized(width=video_width).with_position('center'))

final_clips = []
final_clips.append(caption1)
final_clips.append(combined_clip)
final_clips.append(caption2)
final_clip = concatenate_videoclips(final_clips, method='compose')
final_clip.write_videofile("output.mp4", codec="libx264")
