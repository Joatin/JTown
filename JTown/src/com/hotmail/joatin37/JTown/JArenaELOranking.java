/*
 * Copyright 2013 Joatin Granlund. All rights reserved.
 *
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 * 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list of
 *    conditions and the following disclaimer.
 *
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list
 *    of conditions and the following disclaimer in the documentation and/or other materials
 *    provided with the distribution.
 *
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * 
 * The views and conclusions contained in the software and documentation are those of the
 * authors and contributors and should not be interpreted as representing official policies,
 * either expressed or implied, of anybody else.
 */

package com.hotmail.joatin37.JTown;

/**
 * Used to calculate arena rankings.
 * 
 * @author Joatin
 * 
 * 
 */
public final class JArenaELOranking {

	/**
	 * Culcultaes the new ranking by using a three staged ELOsystem. The
	 * K-factor uses three values, 32 for less than 2400 points, 24 for less
	 * than 3400, and 10 for more than 3400. A player can never get less than 0
	 * points. If a player has less than 0 he is calculated as if he has 1500.
	 * 
	 * @param Winner
	 *            the winners current points
	 * @param Looser
	 *            the loosers current points
	 * @return double[0] the winners new points, double[1] the loosers new
	 *         points.
	 * 
	 * @since 1.0
	 */
	public static double[] CalculateResult1v1(int Winner, int Looser) {
		double win = Winner;
		double los = Looser;
		int Kfactor = 32;
		int Kloose = 32;
		double winchance;
		double loosechance;

		if (win <= 1500) {
			if (los <= 1500) {
				winchance = (1 / (1 + java.lang.Math.pow(10,
						((1500 - 1500) / 400))));
			} else {
				winchance = (1 / (1 + java.lang.Math.pow(10,
						((los - 1500) / 400))));
			}
		} else {
			winchance = (1 / (1 + java.lang.Math.pow(10, ((los - win) / 400))));
		}
		if (los <= 1500) {
			if (win <= 1500) {
				loosechance = (1 / (1 + java.lang.Math.pow(10,
						((1500 - 1500) / 400))));
			} else {
				loosechance = (1 / (1 + java.lang.Math.pow(10,
						((win - 1500) / 400))));
			}
		} else {
			loosechance = (1 / (1 + java.lang.Math.pow(10, ((win - los) / 400))));
		}
		if (win >= 2400) {
			Kfactor = 24;
		} else {
			if (win >= 3400) {
				Kfactor = 10;
			}
		}
		if (los >= 2400) {
			Kloose = 24;
		} else {
			if (los >= 3000) {
				Kloose = 10;
			}
		}

		double[] ret = new double[2];
		ret[0] = win + (Kfactor * (1 - winchance));
		ret[1] = los + (Kloose * (0 - loosechance));
		if (ret[1] < 0) {
			ret[1] = 0;
		}

		return ret;

	}
}
