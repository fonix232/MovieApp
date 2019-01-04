package me.fonix232.movieapp.ui.activity

import me.fonix232.common.ui.activity.BaseActivity
import me.fonix232.movieapp.R
import me.fonix232.movieapp.bindings.MainActivityBinding
import me.fonix232.movieapp.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, MainActivityBinding>(MainViewModel::class, R.layout.activity_main) {

}