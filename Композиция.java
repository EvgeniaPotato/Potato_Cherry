
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
    Public Car()
    {
        this.dvigatel = new Dvigatel(360);
    }
}
