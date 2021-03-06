/*
 * This file is part of Infinitest.
 *
 * Copyright (C) 2010
 * "Ben Rady" <benrady@gmail.com>,
 * "Rod Coffin" <rfciii@gmail.com>,
 * "Ryan Breidenbach" <ryan.breidenbach@gmail.com>, et al.
 *
 * Infinitest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Infinitest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Infinitest.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.infinitest;

import static org.infinitest.util.FakeEnvironments.*;

import java.io.File;
import java.util.List;

public class StandaloneClasspath implements ClasspathProvider
{
    private final List<File> classDirs;
    private final String classpath;
    private final List<File> classDirsInClasspath;

    public StandaloneClasspath(List<File> classOutputDirs, String classpath)
    {
        this(classOutputDirs, classOutputDirs, classpath);
    }

    public StandaloneClasspath(List<File> classOutputDirs, List<File> classDirsInClasspath, String classpath)
    {
        this.classDirs = classOutputDirs;
        this.classDirsInClasspath = classDirsInClasspath;
        this.classpath = classpath;
    }

    public StandaloneClasspath(List<File> classOutputDirs)
    {
        this(classOutputDirs, systemClasspath());
    }

    public List<File> getClassOutputDirs()
    {
        return classDirs;
    }

    public String getCompleteClasspath()
    {
        return classpath;
    }

    @Override
    public String toString()
    {
        return "Classpath :[" + classpath + "]  Class Directories: [" + classDirs + "]";
    }

    public List<File> classDirectoriesInClasspath()
    {
        return classDirsInClasspath;
    }

    public String getSystemClasspath()
    {
        return systemClasspath();
    }

}
