package com.example.lab_20220324

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {

    lateinit var img : ImageView
    lateinit var btnLeft : Button
    lateinit var btnRight : Button
    var thisImage = 'a'
    

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        title = "고양이 갤러리"

        img = findViewById(R.id.imgView)
        btnLeft = findViewById(R.id.BtnLeft)
        btnRight = findViewById(R.id.BtnRight)

        btnLeft.setOnTouchListener { view, motionEvent ->
            if (thisImage == 'a') {
                thisImage = 'z'
                img.setImageResource(R.drawable.z)
            } else if (thisImage == 'b') {
                thisImage = 'a'
                img.setImageResource(R.drawable.a)
            } else if (thisImage == 'c') {
                thisImage = 'b'
                img.setImageResource(R.drawable.b)
            } else if (thisImage == 'd') {
                thisImage = 'c'
                img.setImageResource(R.drawable.c)
            } else if (thisImage == 'e') {
                thisImage = 'd'
                img.setImageResource(R.drawable.d)
            } else if (thisImage == 'f') {
                thisImage = 'e'
                img.setImageResource(R.drawable.e)
            } else if (thisImage == 'g') {
                thisImage = 'f'
                img.setImageResource(R.drawable.f)
            } else if (thisImage == 'h') {
                thisImage = 'g'
                img.setImageResource(R.drawable.g)
            } else if (thisImage == 'i') {
                thisImage = 'h'
                img.setImageResource(R.drawable.h)
            } else if (thisImage == 'j') {
                thisImage = 'i'
                img.setImageResource(R.drawable.i)
            } else if (thisImage == 'k') {
                thisImage = 'j'
                img.setImageResource(R.drawable.j)
            } else if (thisImage == 'l') {
                thisImage = 'k'
                img.setImageResource(R.drawable.k)
            } else if (thisImage == 'm') {
                thisImage = 'l'
                img.setImageResource(R.drawable.l)
            } else if (thisImage == 'n') {
                thisImage = 'm'
                img.setImageResource(R.drawable.m)
            } else if (thisImage == 'o') {
                thisImage = 'n'
                img.setImageResource(R.drawable.n)
            } else if (thisImage == 'p') {
                thisImage = 'o'
                img.setImageResource(R.drawable.o)
            } else if (thisImage == 'q') {
                thisImage = 'p'
                img.setImageResource(R.drawable.p)
            } else if (thisImage == 'r') {
                thisImage = 'q'
                img.setImageResource(R.drawable.q)
            }else if (thisImage == 's') {
                thisImage = 'r'
                img.setImageResource(R.drawable.r)
            }else if (thisImage == 't') {
                thisImage = 's'
                img.setImageResource(R.drawable.s)
            }else if (thisImage == 'u') {
                thisImage = 't'
                img.setImageResource(R.drawable.t)
            }else if (thisImage == 'v') {
                thisImage = 'u'
                img.setImageResource(R.drawable.u)
            }else if (thisImage == 'w') {
                thisImage = 'v'
                img.setImageResource(R.drawable.v)
            }else if (thisImage == 'x') {
                thisImage = 'w'
                img.setImageResource(R.drawable.w)
            }else if (thisImage == 'y') {
                thisImage = 'x'
                img.setImageResource(R.drawable.x)
            }else {
                thisImage = 'y'
                img.setImageResource(R.drawable.y)
            }
            false
        }

        btnRight.setOnTouchListener { view, motionEvent ->
            if (thisImage == 'z') {
                thisImage = 'a'
                img.setImageResource(R.drawable.a)
            } else if (thisImage == 'a') {
                thisImage = 'b'
                img.setImageResource(R.drawable.b)
            } else if (thisImage == 'b') {
                thisImage = 'c'
                img.setImageResource(R.drawable.c)
            } else if (thisImage == 'c') {
                thisImage = 'd'
                img.setImageResource(R.drawable.d)
            } else if (thisImage == 'd') {
                thisImage = 'e'
                img.setImageResource(R.drawable.e)
            } else if (thisImage == 'e') {
                thisImage = 'f'
                img.setImageResource(R.drawable.f)
            } else if (thisImage == 'f') {
                thisImage = 'g'
                img.setImageResource(R.drawable.g)
            } else if (thisImage == 'g') {
                thisImage = 'h'
                img.setImageResource(R.drawable.h)
            } else if (thisImage == 'h') {
                thisImage = 'i'
                img.setImageResource(R.drawable.i)
            } else if (thisImage == 'i') {
                thisImage = 'j'
                img.setImageResource(R.drawable.j)
            } else if (thisImage == 'j') {
                thisImage = 'k'
                img.setImageResource(R.drawable.k)
            } else if (thisImage == 'k') {
                thisImage = 'l'
                img.setImageResource(R.drawable.l)
            } else if (thisImage == 'l') {
                thisImage = 'm'
                img.setImageResource(R.drawable.m)
            } else if (thisImage == 'm') {
                thisImage = 'n'
                img.setImageResource(R.drawable.n)
            } else if (thisImage == 'n') {
                thisImage = 'o'
                img.setImageResource(R.drawable.o)
            } else if (thisImage == 'o') {
                thisImage = 'p'
                img.setImageResource(R.drawable.p)
            } else if (thisImage == 'p') {
                thisImage = 'q'
                img.setImageResource(R.drawable.q)
            } else if (thisImage == 'q') {
                thisImage = 'r'
                img.setImageResource(R.drawable.r)
            } else if (thisImage == 'r') {
                thisImage = 's'
                img.setImageResource(R.drawable.s)
            }else if (thisImage == 's') {
                thisImage = 't'
                img.setImageResource(R.drawable.t)
            }else if (thisImage == 't') {
                thisImage = 'u'
                img.setImageResource(R.drawable.u)
            }else if (thisImage == 'u') {
                thisImage = 'v'
                img.setImageResource(R.drawable.v)
            }else if (thisImage == 'v') {
                thisImage = 'w'
                img.setImageResource(R.drawable.w)
            }else if (thisImage == 'w') {
                thisImage = 'x'
                img.setImageResource(R.drawable.x)
            }else if (thisImage == 'x') {
                thisImage = 'y'
                img.setImageResource(R.drawable.y)
            }else {
                thisImage = 'z'
                img.setImageResource(R.drawable.z)
            }
            false
        }

    }

}