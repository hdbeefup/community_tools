package pakfile;

public abstract class pakFileListener
{
  public abstract void writeStarted();
  
  public abstract void writeStopped();
  
  public abstract void writeIsAdvancing(long paramLong);
  
  public abstract void readStarted();
  
  public abstract void readStopped();
  
  public abstract void readIsAdvancing(long paramLong);
}


/* Location:              /home/traildev/javastuff/Java4D.jar!/pakfile/pakFileListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */