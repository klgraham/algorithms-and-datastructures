package org.klgraham.datastructures;

import java.util.Optional;

/**
 * Description of file content.
 *
 * @author kgraham
 *         10/4/16
 */
public class Node<T extends Comparable<T>>
{
	private T item;
	private Optional<Node<T>> next;

	public Node(T item) {
		this.item = item;
		this.next = Optional.empty();
	}

	public T getItem() {
		return item;
	}

	public Optional<Node<T>> getNext() {
		return next;
	}

	public boolean hasNext() {
		return next.isPresent();
	}

	public void setItem(final T item)
	{
		this.item = item;
	}

	public void setNext(final Node<T> next)
	{
		this.next = Optional.ofNullable(next);
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		final Node<?> node = (Node<?>) o;

		return item != null ? item.equals(node.item) : node.item == null;

	}

	@Override
	public int hashCode()
	{
		return item != null ? item.hashCode() : 0;
	}
}
