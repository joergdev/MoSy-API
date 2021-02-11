package com.github.joergdev.mosy.api.response.mockprofile;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.joergdev.mosy.api.model.MockProfile;
import com.github.joergdev.mosy.api.response.AbstractResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadProfilesResponse", propOrder = {"stateOK", "messages", "mockProfiles"})
public class LoadProfilesResponse extends AbstractResponse
{
  @XmlElement(name = "mockProfiles")
  private List<MockProfile> mockProfiles;

  public List<MockProfile> getMockProfiles()
  {
    return mockProfiles;
  }

  public void setMockProfiles(List<MockProfile> mockProfiles)
  {
    this.mockProfiles = mockProfiles;
  }
}