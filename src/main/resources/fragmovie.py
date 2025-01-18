# Code generated from a VideoML scrip
# Video name: fragmovie

from moviepy import *

font = "./font/font.ttf"

video_width = 640
video_height = 360

final_clip_list = []

intro = VideoFileClip("intro.mp4").with_start(0)
intro = intro.with_position(('center', 'center'))
final_clip_list.append(intro)
intro_text = TextClip(text="Fragmovie", font=font, font_size=48, color='white').with_start(intro.start + 2).with_duration(8)
intro_text = intro_text.with_position(('center', 'center'))
intro_text = intro_text.with_effects([vfx.CrossFadeIn(2.0)])
final_clip_list.append(intro_text)
intro_text_creator = TextClip(text="Created by PADD", font=font, font_size=48, color='white').with_start(intro.start + 5).with_duration(5)
intro_text_creator = intro_text_creator.with_position(('center', 'bottom'))
intro_text_creator = intro_text_creator.with_effects([vfx.CrossFadeIn(2.0)])
final_clip_list.append(intro_text_creator)
explosion_left = VideoFileClip("explosion.mp4").subclipped(0, 3).with_start(intro.start)
explosion_left = explosion_left.with_position(('left', 'bottom'))
explosion_left = explosion_left.with_effects([vfx.MaskColor(color=(0, 255, 8), threshold=150, stiffness=5)])
explosion_left = explosion_left.resized(0.3)
final_clip_list.append(explosion_left)
explosion_right = VideoFileClip("explosion.mp4").subclipped(0, 3).with_start(intro.start)
explosion_right = explosion_right.with_position(('right', 'bottom'))
explosion_right = explosion_right.with_effects([vfx.MaskColor(color=(0, 255, 8), threshold=150, stiffness=5)])
explosion_right = explosion_right.resized(0.3)
final_clip_list.append(explosion_right)





zywoo_gameplay = VideoFileClip("gameplay.mp4").subclipped(5, 18).with_start(explosion_right.end)
zywoo_gameplay = zywoo_gameplay.with_position(('center', 'center'))
final_clip_list.append(zywoo_gameplay)
therock_ok1 = VideoFileClip("therock.mp4").subclipped(0, 3).with_start(zywoo_gameplay.start)
therock_ok1 = therock_ok1.with_position(('right', 'bottom'))
therock_ok1 = therock_ok1.with_effects([vfx.MaskColor(color=(0, 255, 8), threshold=150, stiffness=5)])
therock_ok1 = therock_ok1.resized(0.3)
final_clip_list.append(therock_ok1)
therock_ok2 = VideoFileClip("therock.mp4").subclipped(0, 3).with_start(therock_ok1.end)
therock_ok2 = therock_ok2.with_position(('center', 'center'))
final_clip_list.append(therock_ok2)
therock_ok3 = VideoFileClip("therock.mp4").subclipped(0, 3).with_start(therock_ok2.end)
therock_ok3 = therock_ok3.with_position(('center', 'center'))
final_clip_list.append(therock_ok3)
therock_nok = VideoFileClip("therock.mp4").subclipped(3, 4).with_start(therock_ok3.end)
therock_nok = therock_nok.with_position(('center', 'center'))
final_clip_list.append(therock_nok)
final_clip = CompositeVideoClip(final_clip_list, size=(video_width, video_height))
final_clip.write_videofile("fragmovie.mp4", codec="libx264", fps=24)
