package app.prachang.dummy_data.data.database

import app.prachang.dummy_data.data.dao.GmailDao

interface AppDatabase {
    fun getGmailDao(): GmailDao
}