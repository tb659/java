package demo1.demo20File;

import java.io.File;
import java.io.FileFilter;

public class FIleFilterImpl implements FileFilter {

  @Override
  public boolean accept(File file) {
    if (file.getName().toLowerCase().endsWith(".java") || file.isDirectory()) {
      return true;
    }
    return false;
  }
}
