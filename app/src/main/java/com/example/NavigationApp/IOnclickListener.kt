package com.example.NavigationApp

import com.example.NavigationApp.model.Feature

interface IOnclickListener {
    fun onItemClick(id: String)
    fun onIconClick(lat: Double, lon: Double)
}