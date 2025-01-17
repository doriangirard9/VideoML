# Code generated from a VideoML scrip
# Video name: Sound

from moviepy import *

font = "./font/font.ttf"

video_width = 1280
video_height = 720

final_clip_list = []
AUTO_GENERATED_CLIP_2 = VideoFileClip("first_clip.mp4").with_start(0)
AUTO_GENERATED_CLIP_2 = AUTO_GENERATED_CLIP_2.with_position(('center', 'center'))
explanations_list = []
AUTO_GENERATED_CLIP_0 = AudioFileClip("explanation1.mp3").subclipped(0, None).with_start(0).with_effects([afx.MultiplyVolume(0.5)])
# AudioClip not associated with a video.
explanations_list.append(AUTO_GENERATED_CLIP_0)
AUTO_GENERATED_CLIP_1 = AudioFileClip("explanation2.mp3").subclipped(0, None).with_start(AUTO_GENERATED_CLIP_0.end).with_effects([afx.MultiplyVolume(1.0)])
# AudioClip not associated with a video.
explanations_list.append(AUTO_GENERATED_CLIP_1)
explanations = CompositeAudioClip(explanations_list).with_start(AUTO_GENERATED_CLIP_2.start+3).with_end(AUTO_GENERATED_CLIP_2.start+13).subclipped(0, 10)
AUTO_GENERATED_CLIP_2 = AUTO_GENERATED_CLIP_2.with_audio(explanations)
final_clip_list.append(AUTO_GENERATED_CLIP_2)
AUTO_GENERATED_CLIP_3 = VideoFileClip("second_clip.mp4").with_start(AUTO_GENERATED_CLIP_2.end)
AUTO_GENERATED_CLIP_3 = AUTO_GENERATED_CLIP_3.with_position(('center', 'center'))
AUTO_GENERATED_CLIP_4 = AudioFileClip("explanation3.mp3").subclipped(0, AUTO_GENERATED_CLIP_3.end).with_start(AUTO_GENERATED_CLIP_3.start).with_end(AUTO_GENERATED_CLIP_3.end).with_effects([afx.MultiplyVolume(0.2)])
AUTO_GENERATED_CLIP_3 = AUTO_GENERATED_CLIP_3.with_audio(AUTO_GENERATED_CLIP_4)
final_clip_list.append(AUTO_GENERATED_CLIP_3)
final_clip = CompositeVideoClip(final_clip_list, size=(video_width, video_height))
final_clip.write_videofile("Sound.mp4", codec="libx264", fps=24)
