SELECT Country.Name
FROM Country
  INNER JOIN City ON Country.ID = City.CityID
WHERE Population > 400;
SELECT Country.Name
FROM Country
  LEFT JOIN City ON Country.ID = City.CountryID
  LEFT JOIN Building ON City.CityID = Building.CityID
WHERE Building.CityID IS NULL;

