package com.example.chat.dagger.commentnotify;

import com.example.chat.MainRepositoryManager;
import com.example.chat.adapter.CommentNotifyAdapter;
import com.example.chat.mvp.commentnotify.CommentNotifyActivity;
import com.example.chat.mvp.commentnotify.CommentNotifyModel;
import com.example.chat.mvp.commentnotify.CommentNotifyPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称:    NewFastFrame
 * 创建人:      李晨
 * 创建时间:    2018/5/19     14:02
 */
@Module
public class CommentNotifyModule {
    private CommentNotifyActivity commentNotifyActivity;

    public CommentNotifyModule(CommentNotifyActivity commentNotifyActivity) {
        this.commentNotifyActivity = commentNotifyActivity;
    }


    @Provides
    public CommentNotifyAdapter providerAdapter(){
        return new CommentNotifyAdapter();
    }


    @Provides
    public CommentNotifyPresenter providerPresenter(CommentNotifyModel commentNotifyModel){
        return new CommentNotifyPresenter(commentNotifyActivity,commentNotifyModel);
    }


    @Provides
    public CommentNotifyModel providerModel(MainRepositoryManager mainRepositoryManager){
        return new CommentNotifyModel(mainRepositoryManager);
    }


}
