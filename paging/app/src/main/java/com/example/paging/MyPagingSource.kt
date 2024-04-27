package com.example.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

//목록 리스트가 보여질때 몇번부터 시작할지 결정위한 임시 번호
private const val STARTING_KEY = 1

//PagingSource<key, value>
class MyPagingSource: PagingSource<Int, User>() {

    init {
        Log.d("MyPagingSource", "init")
    }

    //페이징이 실행되면 어떻게 할 것인지 정하는 부분
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {

        //key값이 널이 아니면 STARTING_KEY값 넣어준다.
        val page = params.key ?: STARTING_KEY

        //1부터 시작해서 30까지 실행된다.
        val range = page.until(page + params.loadSize)

        if(page !=STARTING_KEY ){
            delay(3000)
        }

        return LoadResult.Page(
            data = range.map { number ->
                User(
                    id = number,
                    userName = "UserNumber is $number"
                )
            },
            //위로 올렸을 때,
            //아래로 스크롤 했을 때
            prevKey = null,
            nextKey = range.last + 1
        )
    }

    //새로고침을 누르면 어떻게 되는지 정하는 부분
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {

        return null
    }

}
