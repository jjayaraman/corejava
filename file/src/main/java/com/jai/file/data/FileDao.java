package com.jai.file.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class FileDao {

	private static final Logger LOG = Logger.getLogger(FileDao.class);

	Connection connection = null;

	private Connection getConnection() {

		String URL = "jdbc:oracle:thin:@eb2dv-ora04.ebauk.local:1521/ebad2p_db1.ebauk.local";

		if (connection == null) {
			try {
				return DriverManager.getConnection(URL, "rwasowski", "rwasowski");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public void insertData(Long templateId, String fileName, String contents) {

		String procedure = "{ call insert_attachement(:I_TEMPLATE_ID, :I_FILE_NAME, :I_B_ATTACHEMENT, :O_ATTACHEMENT_ID) }";

		LOG.info("Calling stored procedure : " + procedure);

		OracleCallableStatement callableStatement = null;
		try {
			callableStatement = (OracleCallableStatement) getConnection().prepareCall(procedure);

			if (templateId != null) {
				callableStatement.setLong("I_TEMPLATE_ID", templateId);
			} else {
				callableStatement.setNull("I_TEMPLATE_ID", OracleTypes.NUMBER);
			}

			if (fileName != null) {
				callableStatement.setString("I_FILE_NAME", fileName);
			} else {
				callableStatement.setNull("I_FILE_NAME", OracleTypes.VARCHAR);
			}

			if (contents != null) {
				Blob myBlob = getConnection().createBlob();
				myBlob.setBytes(contents.getBytes().length, contents.getBytes());
				callableStatement.setBlob("I_B_ATTACHEMENT", myBlob);
			} else {
				callableStatement.setNull("I_B_ATTACHEMENT", OracleTypes.BLOB);
			}

			callableStatement.registerOutParameter("O_ATTACHEMENT_ID", OracleTypes.NUMBER);

			callableStatement.executeUpdate();

			Long attachmentId = callableStatement.getLong("O_ATTACHEMENT_ID");

			LOG.info("Returned : " + attachmentId);

		} catch (SQLException e) {
			LOG.error(e);
		} finally {
			if (callableStatement != null) {
				try {
					callableStatement.close();
				} catch (SQLException e) {
					LOG.error(e);
				}
			}
		}

	}

	private static String readFile(String file) {
		String contents = "";
		try {
			contents = FileUtils.readFileToString(new File(file), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contents;
	}

	public void directInsert(String fileName, InputStream inputStream) {

		PreparedStatement pstmt;
		try {

			String sql = " INSERT INTO rwasowski.template_attachements(attachement_id,related_id,file_name,attachement) VALUES (?,?,?,?)";
			pstmt = getConnection().prepareStatement(sql);

			pstmt.setLong(1, 3);
			pstmt.setLong(2, 3);
			pstmt.setString(3, fileName);
			pstmt.setBlob(4, inputStream);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public InputStream directRead(String fileName) {

		InputStream inputStream = null;
		PreparedStatement pstmt;
		try {

			String sql = "select attachement from rwasowski.template_attachements where file_name = ? ";
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, fileName);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				inputStream = rs.getBinaryStream(1);
				System.out.println("read....");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inputStream;
	}

	public static void main(String[] args) {

		// String file = "CRDIV 133 template_notifying_intended_use_srb.doc";
		String file = "templates.zip";
		// String file = "CRR 315(3) 317(4)
		// NotificationTemplates_OpRisk_v3.xlsx";

		FileDao dao = new FileDao();
		// dao.insertData(1L, file, readFile(file));

		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("C:/eGate 2.0/templates/" + file));
			System.out.println("IN size : " + inputStream.available());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Insert
		dao.directInsert(file, inputStream);

		// Read
		InputStream is = dao.directRead(file);

		FileOutputStream fos = null;
		byte[] buffer = new byte[2048];
		try {
			fos = new FileOutputStream("c:/temp/" + file);
			int len = 0;
			while ((len = is.read(buffer)) > 0) {
				fos.write(buffer);
			}
			fos.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("dONE...");
	}

}
