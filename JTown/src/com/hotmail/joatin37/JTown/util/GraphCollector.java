package com.hotmail.joatin37.JTown.util;

import java.io.IOException;

import com.hotmail.joatin37.JTown.JTown;

public class GraphCollector {

	private final JTown jtown;
	private BukkitMetrics metrics;

	public GraphCollector(JTown town) {
		this.jtown = town;

		try {
			this.metrics = new BukkitMetrics(this.jtown);
			this.metrics.start();
		} catch (IOException e) {
			// Failed to submit the stats :-(
		}
	}
}
