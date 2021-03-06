package com.plcoding.audioplayer.adapters

import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import com.plcoding.audioplayer.R
import kotlinx.android.synthetic.main.list_item.view.*
import javax.inject.Inject

class AudioAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseAudioAdapter(R.layout.list_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: BaseAudioAdapter.SongViewHolder, position: Int) {
        val song = audios[position]
        holder.itemView.apply {
            tvPrimary.text = song.title
            tvSecondary.text = song.subtitle
            glide.load(song.imageUrl).into(ivItemImage)

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }

}