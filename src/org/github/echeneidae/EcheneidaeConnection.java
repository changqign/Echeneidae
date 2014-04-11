package org.github.echeneidae;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

/**
 * @author hongliuliao
 * 2014-4-11 上午10:51:19
 */
public class EcheneidaeConnection implements Connection {
	
	/**
	 * the datasource which create this connection
	 */
	private EcheneidaeDataSource echeneidaeDataSource;
	
	private boolean valid;
	
	private Connection rawConn;
	
	/**
	 * @param rawConn
	 */
	public EcheneidaeConnection(EcheneidaeDataSource echeneidaeDataSource, Connection rawConn) {
		super();
		this.echeneidaeDataSource = echeneidaeDataSource;
		this.rawConn = rawConn;
		valid = true;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return rawConn.unwrap(iface);
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return rawConn.isWrapperFor(iface);
	}

	@Override
	public Statement createStatement() throws SQLException {
		Statement rawStatement = rawConn.createStatement();
		return new EcheneidaeStatement(this, rawStatement);
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		return rawConn.nativeSQL(sql);
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		rawConn.setAutoCommit(autoCommit);
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		return rawConn.getAutoCommit();
	}

	@Override
	public void commit() throws SQLException {
		rawConn.commit();
	}

	@Override
	public void rollback() throws SQLException {
		rawConn.rollback();
	}

	@Override
	public void close() throws SQLException {
		rawConn.close();
	}

	@Override
	public boolean isClosed() throws SQLException {
		return rawConn.isClosed();
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		return rawConn.getMetaData();
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		rawConn.setReadOnly(readOnly);
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		return rawConn.isReadOnly();
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		rawConn.setCatalog(catalog);
	}

	@Override
	public String getCatalog() throws SQLException {
		return rawConn.getCatalog();
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		rawConn.setTransactionIsolation(level);
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		return rawConn.getTransactionIsolation();
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return rawConn.getWarnings();
	}

	@Override
	public void clearWarnings() throws SQLException {
		rawConn.clearWarnings();
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		return rawConn.getTypeMap();
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		rawConn.setTypeMap(map);
	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		rawConn.setHoldability(holdability);
	}

	@Override
	public int getHoldability() throws SQLException {
		return rawConn.getHoldability();
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		return rawConn.setSavepoint();
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		return rawConn.setSavepoint(name);
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		rawConn.rollback();
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		rawConn.releaseSavepoint(savepoint);
	}

	@Override
	public Statement createStatement(int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		return rawConn.createClob();
	}

	@Override
	public Blob createBlob() throws SQLException {
		return rawConn.createBlob();
	}

	@Override
	public NClob createNClob() throws SQLException {
		return rawConn.createNClob();
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		return rawConn.createSQLXML();
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		return rawConn.isValid(timeout);
	}

	@Override
	public void setClientInfo(String name, String value)
			throws SQLClientInfoException {
		rawConn.setClientInfo(name, value);
	}

	@Override
	public void setClientInfo(Properties properties)
			throws SQLClientInfoException {
		rawConn.setClientInfo(properties);
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		return rawConn.getClientInfo(name);
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		return rawConn.getClientInfo();
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements)
			throws SQLException {
		return rawConn.createArrayOf(typeName, elements);
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes)
			throws SQLException {
		return rawConn.createStruct(typeName, attributes);
	}

	public EcheneidaeDataSource getEcheneidaeDataSource() {
		return echeneidaeDataSource;
	}
	
	/**
	 * 通过 执行{@link EcheneidaeDataSource#getValidationQuery()}语句判断是否连接正常
	 * @return
	 */
	public boolean validateConnect() {
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = rawConn.createStatement();
			rs = statement.executeQuery(echeneidaeDataSource.getValidationQuery());
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {}
			}
		}
	}

}
