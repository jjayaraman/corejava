package com.jai.corejava.code.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MssqlCrud {

	static String DB_URL = "jdbc:sqlserver://eb2dv-sql05.ebauk.local;databaseName=dmm_1;user=SAM_User;password=SAM_User";

	static Connection connection = null;

	public MssqlCrud() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(DB_URL);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertBlob(String filePath, int dataMartId) {
		String sql = "update DataMart set TemplateExcelFile = ? where DataMartID = ?";
		PreparedStatement pst = null;
		InputStream fileStream = null;
		try {
			pst = connection.prepareStatement(sql);
			fileStream = new FileInputStream(new File(filePath));
			pst.setBlob(1, fileStream);
			pst.setInt(2, dataMartId);
			pst.executeUpdate();

		}
		catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}

		finally {

			try {
				if (fileStream != null) {
					fileStream.close();
				}
				if (pst != null) {
					pst.close();
				}

			}
			catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		MssqlCrud handle = new MssqlCrud();

		try {
			String filePath = "src/main/resources/CubeTemplateGenericJJ14.xlsm";
			int dataMartId = 59;
			handle.insertBlob(filePath, dataMartId);
			System.out.println("done...");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
