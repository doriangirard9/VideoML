# Code generated from a VideoML script
# Video name: Work

from moviepy import *

font = "./font/font.ttf"

clip1a = VideoFileClip("first_clip.mp4").subclipped(10, 25)
clip1b = VideoFileClip("clip2.mp4").subclipped(10, 55)

video_width = 1280
video_height = 720

final_clips = []
caption1 = (TextClip(text="intro", font=font, font_size=48, color='white', bg_color='black').with_duration(10).resized(width=video_width, height=video_height).with_position(('center', 'center')).with_start(0))
final_clips.append(caption1)
clip1a = clip1a.with_start(10)
final_clips.append(clip1a)
caption2 = (TextClip(text="s1", font=font, font_size=48, color='white', bg_color=None).with_duration(10).resized(width=video_width, height=video_height).with_position(('center', 'center')).with_start(clip1a.start + 0))
final_clips.append(caption2)
caption3 = (TextClip(text="s2", font=font, font_size=48, color='white', bg_color=None).with_duration(10).resized(width=video_width, height=video_height).with_position(('center', 'center')).with_start(caption1.end + 5))
final_clips.append(caption3)
clip1b = clip1b.with_start(clip1a.end)
final_clips.append(clip1b)
caption4 = (TextClip(text="s3", font=font, font_size=48, color='white', bg_color=None).with_duration(15).resized(width=video_width, height=video_height).with_position(('center', 'center')).with_start(clip1b.start-5))
final_clips.append(caption4)
caption5 = (TextClip(text="thanks", font=font, font_size=48, color='white', bg_color='black').with_duration(10).resized(width=video_width, height=video_height).with_position(('center', 'center')).with_start(clip1b.end + 0))
final_clips.append(caption5)
final_clip = CompositeVideoClip(final_clips)
final_clip.write_videofile("output.mp4", codec="libx264")
