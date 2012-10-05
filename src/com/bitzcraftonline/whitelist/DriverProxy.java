package com.bitzcraftonline.whitelist;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class DriverProxy implements Driver
{
  //Attributes
  private Driver m_Driver;

  public DriverProxy( Driver driver )
  {
    m_Driver = driver;
  }

  public Connection connect(String url, Properties info) throws SQLException
  {
    return m_Driver.connect(url, info);
  }

  public boolean acceptsURL(String url) throws SQLException
  {
    return m_Driver.acceptsURL(url);
  }

  public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException
  {
    return m_Driver.getPropertyInfo(url, info);
  }

  public int getMajorVersion()
  {
    return m_Driver.getMajorVersion();
  }

  public int getMinorVersion()
  {
    return m_Driver.getMinorVersion();
  }

  public boolean jdbcCompliant()
  {
    return m_Driver.jdbcCompliant();
  }

@Override
public Logger getParentLogger() throws SQLFeatureNotSupportedException {
	return null;
}
}