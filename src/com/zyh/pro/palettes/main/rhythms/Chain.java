package com.zyh.pro.palettes.main.rhythms;

public abstract class Chain<Consumed> {

	private Chain<Consumed> next;

	protected Chain() {
	}

	public boolean consume(Consumed rhythm) {
		if (isConsumable(rhythm)) {   // consume it if item is match
			onConsume(rhythm);
			return true;
		}
		if (next != null)         // send it to next if possible
			return next.consume(rhythm);
		return false;             // there is no way to consume this rhythm
	}

	protected abstract boolean isConsumable(Consumed rhythm);

	protected abstract void onConsume(Consumed rhythm);

	public static class Builder<Consumed> {

		private Chain<Consumed> result;

		private Chain<Consumed> currentChain;

		public Builder<Consumed> next(Chain<Consumed> next) {
			if (result == null) {
				result = currentChain = next;
				return this;
			}
			currentChain.next = next;
			currentChain = next;
			return this;
		}

		public Chain<Consumed> build() {
			return result;
		}
	}
}
