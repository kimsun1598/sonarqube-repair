/**
 * Copyright (C) 2006-2017 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon.reflect.reference;


import java.util.Set;
import spoon.reflect.annotations.PropertyGetter;
import spoon.reflect.annotations.PropertySetter;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.path.CtRole;
import spoon.support.DerivedProperty;


/**
 * This interface defines a reference to a
 * {@link spoon.reflect.declaration.CtVariable} or sub-type.
 */
public interface CtVariableReference<T> extends CtReference {
    /**
     * Gets the type of the variable.
     */
    @PropertyGetter(role = CtRole.TYPE)
    CtTypeReference<T> getType();

    /**
     * Sets the type of the variable.
     */
    @PropertySetter(role = CtRole.TYPE)
    <C extends CtVariableReference<T>> C setType(CtTypeReference<T> type);

    /**
     * Tries to get the declaration of the reference.
     */
    @DerivedProperty
    CtVariable<T> getDeclaration();

    /**
     * Gets modifiers of the reference.
     */
    Set<ModifierKind> getModifiers();

    @Override
    CtVariableReference<T> clone();
}
