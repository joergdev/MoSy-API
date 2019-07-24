package com.github.joergdev.mosy.api.model.core;

public abstract class AbstractModel
{
  private boolean delete;

  public boolean isDelete()
  {
    return delete;
  }

  public void setDelete(boolean delete)
  {
    this.delete = delete;
  }
}