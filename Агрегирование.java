Class Dvigatel
{
    int power;
    Public Dvigatel(int d)
    {
       power = d;
    }
}        
Class Car
{
    String model = "Ferrari";
    Dvigatel dvigatel;
    Public Car(Dvigatel someDvigatel)
    {
         this.dvigatel = someDvigatel;
    }
}

Dvigatel goodDvigatel = new Dvigatel(360);
Car Ferrari = new Car(goodDvigatel);
