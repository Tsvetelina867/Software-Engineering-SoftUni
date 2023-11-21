package ReflectionExercise.barracksWars.core.factories;

import ReflectionExercise.barracksWars.interfaces.Unit;
import ReflectionExercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"ReflectionExercise.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit newUnit = null;

		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME +  unitType);
			Constructor<Unit> unitConstr = unitClass.getConstructor();
			newUnit = unitConstr.newInstance();

		} catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException |
                 IllegalAccessException e) {
			e.printStackTrace();
		}

        return newUnit;
	}
}
