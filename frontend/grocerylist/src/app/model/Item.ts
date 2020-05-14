import { List } from './List';
export class Item {
  constructor(
    public id: number,
    public listId: List,
    public name: string,
    public type: string,
    public price: number
  ) {}
}
