package com.bitzcraftonline.whitelist;

import java.io.File;
import java.util.TimerTask;
        
public class FileWatcher extends TimerTask
{
  private File m_File;
  private long m_LastModified;
  private volatile  boolean m_WasChanged;
  
  FileWatcher(File file)
  {
    m_File = file;
    m_LastModified = m_File.lastModified();
  }

  @Override
  public void run()
  {
    if ( m_LastModified != m_File.lastModified() )
    {
      m_LastModified = m_File.lastModified();
      if ( !m_WasChanged )
      {
        m_WasChanged = true;
        System.out.println("Whitelist: Whitelist.txt was updated. Whitelist was scheduled for reloading.");
      }
    }
  }

  public boolean wasFileModified()
  {
    return m_WasChanged;
  }

  public void resetFileModifiedState()
  {
    m_WasChanged = false;
  }

}
