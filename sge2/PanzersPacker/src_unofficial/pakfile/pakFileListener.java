package pakfile;

public abstract interface pakFileListener
{
  public abstract void writeStarted();
  
  public abstract void writeStopped();
  
  public abstract void writeIsAdvancing(long paramLong, String paramString);
  
  public abstract void readStarted();
  
  public abstract void readStopped();
  
  public abstract void readIsAdvancing(long paramLong, String paramString);
  
  public abstract void aborted(String paramString);
}


/* Location:              /home/traildev/javastuff/panzersPacker.jar!/pakfile/pakFileListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */