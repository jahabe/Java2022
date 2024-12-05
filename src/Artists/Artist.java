package Artists;
import java.util.Objects;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        Artist.java
 * Description  A class representing the Artist in Artists quiz  game. 
 *              Implements the Comparable interface.
 * Project      Composers Database
 * Platform     jdk 1.8.0_214; NetBeans IDE 11.3; Windows 10
 * Course       CS 142, EdCC
 * Date         3/6/2021
 * Histoly log  5/10/2020
 * @author	<i>Niko Culevski</i>
 * @version 	%1% %0%
 * @see         java.lang.Comparable
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Artist implements Comparable
{
    private String name;
    private int birthYear;
    private String city;
    private String country;
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Artist()-default constructor
     * Description  Creates defaul (empty) artist.
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public Artist()
    {
        name = "";
        birthYear = 0;
        city = "";
        country = "";
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Artist()-overloaded constructor
     * Description  Assigs parameters to instance variables.
     * @param       name String
     * @param       birthYear int
     * @param       city String
     * @param       country String
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Artist(String name, int birthYear, String city, String country)
    {
        this.name = name;
        this.birthYear = birthYear;
        this.city = city;
        this.country = country;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  Artist()-copy constructor
     * Description  Assigs parameters from another artist.
     * @param       another Artist
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Artist(Artist another)
    {        
        this.name = another.name;
        this.birthYear = another.birthYear;
        this.city = another.city;
        this.country = another.country;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getName()
     * Description  Getter method to return name of artist.
     * @return      name String
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getName()
    {
        return name;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setName()
     * Description  Setter method to set artist's name.
     * @param       name String
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setName(String name)
    {
        this.name = name;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getBirthYear()
     * Description  Getter method to return birth year of artist.
     * @return      birthYear int
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getBirthYear()
    {
        return birthYear;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setBirthYear()
     * Description  Setter method to set artist's birth year.
     * @param       birthYear int
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setBirthYear(int birthYear)
    {
        this.birthYear = birthYear;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getCity()
     * Description  Getter method to return birth city of artist.
     * @return      city String
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getCity()
    {
        return city;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setCity()
     * Description  Setter method to set artist's name.
     * @param       city String
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setCity(String city)
    {
        this.city = city;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getCountry()
     * Description  Getter method to return birth country of artist.
     * @return      country String
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getCountry()
    {
        return country;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setCity()
     * Description  Setter method to set artist's country,
     * @param       country String
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setCountry(String country)
    {
        this.country = country;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       hashCode()
     * Description  Overridden method to set hash code for the artist.
     * @return      hashcode int
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public int hashCode()
    {
        int hash = 5;
        return hash;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       equals()
     * Description  Overridden method to check equality between artists. They
     *              are distinct only if name and year of birth differ.
     * @return      true or flase boolean
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Artist other = (Artist) obj;
        if (this.birthYear != other.birthYear)
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        return true;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       equals()
     * Description  Overridden method to display fields of an artist.
     * @return      true or flase boolean
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString()
    {
        return name + "," + birthYear + "," + city + 
            "," + country;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  compareTo()
     * Description  Required method to compare two artist by names and if names
     *              are equal then by age.
     * @param       obj Object
     * @author      <i>Niko Culevski</i>
     * Date         3/6/2021
     * History Log  7/18/2018, 5/10/2020
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public int compareTo(Object obj)
    {
        Artist otherPerson = (Artist) obj;
        // if names are equal compare then by age
        if((this.getName()).equalsIgnoreCase(otherPerson.getName()))        
            return this.birthYear - ((Artist) obj).birthYear;
        else    // otherwise, compare by name
           return  (this.getName().toLowerCase()).compareTo(otherPerson.getName().toLowerCase());
    }    
}
