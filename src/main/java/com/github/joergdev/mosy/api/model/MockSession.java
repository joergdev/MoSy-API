package com.github.joergdev.mosy.api.model;

import java.time.LocalDateTime;
import com.github.joergdev.mosy.api.model.core.AbstractModel;

public class MockSession extends AbstractModel
{
  private Integer mockSessionID;
  private LocalDateTime created;

  public Integer getMockSessionID()
  {
    return mockSessionID;
  }

  public void setMockSessionID(Integer mockSessionID)
  {
    this.mockSessionID = mockSessionID;
  }

  public LocalDateTime getCreated()
  {
    return created;
  }

  public void setCreated(LocalDateTime created)
  {
    this.created = created;
  }
}