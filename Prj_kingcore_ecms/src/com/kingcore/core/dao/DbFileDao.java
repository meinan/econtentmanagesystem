package com.kingcore.core.dao;

import com.kingcore.common.hibernate3.Updater;
import com.kingcore.core.entity.DbFile;

public interface DbFileDao {
	public DbFile findById(String id);

	public DbFile save(DbFile bean);

	public DbFile updateByUpdater(Updater<DbFile> updater);

	public DbFile deleteById(String id);
}