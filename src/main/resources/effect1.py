# Code generated from a VideoML script
# Video name: TryingEffects

from moviepy import *

font = "./font/font.ttf"

video_width = 1280
video_height = 720

final_clips = []
caption1 = (TextClip(text="intro", font=font, font_size=48, color='white').with_duration(10).with_position('center').with_start(0))
final_clips.append(caption1)
clip1a = VideoFileClip("first_clip.mp4").subclipped(10, 25).with_start(caption1.end)
clip1a = clip1a.with_effects([vfx.Freeze(3.0, 5.0)])
clip1a = clip1a.with_start(10).with_end(clip1a.end)
clip1a = clip1a.resized(0.3)
clip1a = clip1a.with_effects([vfx.Rotate(61)])
clip1a = clip1a.with_effects([vfx.MultiplySpeed(1.6)])
clip1a = clip1a.with_start(10).with_end(clip1a.end)
final_clips.append(clip1a)
clip1b = VideoFileClip("clip2.mp4").subclipped(10, 55).with_start(clip1a.end)
final_clips.append(clip1b)
caption2 = (TextClip(text="s1", font=font, font_size=48, color='white').with_duration(10).with_position('center').with_start(clip1a.start + 0))
final_clips.append(caption2)
caption3 = (TextClip(text="s2", font=font, font_size=48, color='white').with_duration(10).with_position('center').with_start(caption2.end + 5 + 0))
final_clips.append(caption3)
caption4 = (TextClip(text="s3", font=font, font_size=48, color='white').with_duration(15).with_position('center').with_start(clip1b.start-5 + 0))
final_clips.append(caption4)
caption5 = (TextClip(text="thanks", font=font, font_size=48, color='white').with_duration(10).with_position('center').with_start(clip1b.end))
final_clips.append(caption5)
final_clip = CompositeVideoClip(final_clips, size=(video_width, video_height))
final_clip.write_videofile("output.mp4", codec="libx264")
