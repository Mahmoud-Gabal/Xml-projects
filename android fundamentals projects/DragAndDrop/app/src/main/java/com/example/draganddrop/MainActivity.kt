package com.example.draganddrop

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.View.DragShadowBuilder
import android.view.View.OnDragListener
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drag_view = findViewById<View>(R.id.Drag_view)
        drag_view.setOnLongClickListener{
            val clip_text = "this is the drag_view text"
            val item = ClipData.Item(clip_text)
            val mmi_type = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clip_text,mmi_type,item)

            val dragshadowbuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data,dragshadowbuilder,it,0)
            it.visibility = View.INVISIBLE
            true
        }
        val draglistener = View.OnDragListener { view, event ->
            when(event.action){
                DragEvent.ACTION_DRAG_STARTED -> {
                    event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DRAG_LOCATION -> true
                DragEvent.ACTION_DRAG_EXITED ->{
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DROP -> {
                    val item = event.clipData.getItemAt(0)
                    val dataString = item.text
                    Toast.makeText(this,dataString,Toast.LENGTH_SHORT).show()
                    view.invalidate()

                    val v = event.localState as View
                    val owner = v.parent as ViewGroup
                    owner.removeView(v)
                    val distination = view as LinearLayout
                    distination.addView(v)
                    v.visibility = View.VISIBLE
                    true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    view.invalidate()
                    true
                }else -> false
            }
        }
        val lltop = findViewById<LinearLayout>(R.id.lltop)
        val llbottom = findViewById<LinearLayout>(R.id.llbottom)
        lltop.setOnDragListener(draglistener)
        llbottom.setOnDragListener(draglistener)

    }
}