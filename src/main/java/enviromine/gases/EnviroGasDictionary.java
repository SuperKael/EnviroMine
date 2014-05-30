package enviromine.gases;

import java.awt.Color;
import java.util.logging.Level;
import enviromine.core.EnviroMine;
import enviromine.gases.types.GasCarbonDioxide;
import enviromine.gases.types.GasCarbonMonoxide;
import enviromine.gases.types.GasFire;
import enviromine.gases.types.GasHydrogenSulfide;
import enviromine.gases.types.GasMethane;

public class EnviroGasDictionary
{
	public static EnviroGas[] gasList = new EnviroGas[128];
	
	public static EnviroGas gasFire = new GasFire("Gas Fire", 0);
	public static EnviroGas carbonMonoxide = new GasCarbonMonoxide("Carbon Monoxide", 1);
	public static EnviroGas carbonDioxide = new GasCarbonDioxide("Carbon Dioxide", 2);
	public static EnviroGas hydrogenSulfide = new GasHydrogenSulfide("Hydrogen Sulfide", 3);
	public static EnviroGas methane = new GasMethane("Methane", 4);
	
	public static void addNewGas(EnviroGas newGas, int id)
	{
		if(id < 128 && id >= 0)
		{
			if(gasList[id] == null)
			{
				gasList[id] = newGas;
				EnviroMine.logger.log(Level.INFO, "Registered gas " + newGas.name);
			} else
			{
				EnviroMine.logger.log(Level.WARNING, "Unable to add gas " + newGas.name + " to dictionary: ID " + id + " is used!");
			}
		} else
		{
			EnviroMine.logger.log(Level.WARNING, "Unable to add gas " + newGas.name + " to dictionary: ID out of bounds!");
		}
	}
}
