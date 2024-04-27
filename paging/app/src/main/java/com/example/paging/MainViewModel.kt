package com.example.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.cachedIn
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel(){


    val items : Flow<PagingData<User>> = Pager(
       config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            MyPagingSource()
        }
    ).flow
        .cachedIn(viewModelScope) //이 부분으 추가해야 로테이션에도 데이터를 유지한다.
}