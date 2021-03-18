package de.joergdev.mosy.api.model;

import java.util.ArrayList;
import java.util.List;
import de.joergdev.mosy.api.model.core.AbstractModel;

public class BaseData extends AbstractModel
{
  // Data GlobalConfig
  private Boolean mockActiveOnStartup;
  private Boolean mockActive;
  private Boolean routingOnNoMockData;
  private Integer ttlMockProfile;
  private Integer ttlRecordSession;

  private Boolean record;

  private final List<Interface> interfaces = new ArrayList<>();

  private Integer countRecordSessions;
  private Integer countMockProfiles;
  private Integer countRecords;

  public Boolean getMockActiveOnStartup()
  {
    return mockActiveOnStartup;
  }

  public void setMockActiveOnStartup(Boolean mockActiveOnStartup)
  {
    this.mockActiveOnStartup = mockActiveOnStartup;
  }

  public Boolean getMockActive()
  {
    return mockActive;
  }

  public void setMockActive(Boolean mockActive)
  {
    this.mockActive = mockActive;
  }

  public List<Interface> getInterfaces()
  {
    return interfaces;
  }

  public Boolean getRecord()
  {
    return record;
  }

  public void setRecord(Boolean record)
  {
    this.record = record;
  }

  public Boolean getRoutingOnNoMockData()
  {
    return routingOnNoMockData;
  }

  public void setRoutingOnNoMockData(Boolean routingOnNoMockData)
  {
    this.routingOnNoMockData = routingOnNoMockData;
  }

  public Integer getCountRecords()
  {
    return countRecords;
  }

  public void setCountRecords(Integer countRecords)
  {
    this.countRecords = countRecords;
  }

  /**
   * @return the countRecordSessions
   */
  public Integer getCountRecordSessions()
  {
    return countRecordSessions;
  }

  /**
   * @param countRecordSessions the countRecordSessions to set
   */
  public void setCountRecordSessions(Integer countRecordSessions)
  {
    this.countRecordSessions = countRecordSessions;
  }

  /**
   * @return the countMockProfiles
   */
  public Integer getCountMockProfiles()
  {
    return countMockProfiles;
  }

  /**
   * @param countMockProfiles the countMockProfiles to set
   */
  public void setCountMockProfiles(Integer countMockProfiles)
  {
    this.countMockProfiles = countMockProfiles;
  }

  /**
   * @return the ttlMockProfile
   */
  public Integer getTtlMockProfile()
  {
    return ttlMockProfile;
  }

  /**
   * @param ttlMockProfile the ttlMockProfile to set
   */
  public void setTtlMockProfile(Integer ttlMockProfile)
  {
    this.ttlMockProfile = ttlMockProfile;
  }

  /**
   * @return the ttlRecordSession
   */
  public Integer getTtlRecordSession()
  {
    return ttlRecordSession;
  }

  /**
   * @param ttlRecordSession the ttlRecordSession to set
   */
  public void setTtlRecordSession(Integer ttlRecordSession)
  {
    this.ttlRecordSession = ttlRecordSession;
  }
}