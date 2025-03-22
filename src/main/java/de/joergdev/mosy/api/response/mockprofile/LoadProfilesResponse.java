package de.joergdev.mosy.api.response.mockprofile;

import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import de.joergdev.mosy.api.model.MockProfile;
import de.joergdev.mosy.api.response.AbstractResponse;

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