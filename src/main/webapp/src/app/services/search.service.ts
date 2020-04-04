import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import config from '../../config';
import IEvent from '../models/event';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  headers = new HttpHeaders({'Access-Control-Allow-Origin': config.SERVER_BASE_URL});

  public searchResults: IEvent[];
  public queryParams: {};

  constructor(private http: HttpClient) {
  }

  getAllEvents(formParams: IEvent): Observable<IEvent[]> {
    const url = config.SERVER_BASE_URL + '/events';

    let queryParams = {};
    for (const param in formParams) {
      if (formParams.hasOwnProperty(param) && formParams[param] !== null) {
        if (formParams[param].hasOwnProperty('_isAMomentObject')) {
          formParams[param] = formParams[param].format('YYYY-MM-DD');
        }
        queryParams = {...queryParams, ...{[param]: formParams[param]}};
      }
    }

    this.queryParams = queryParams;

    return this.http.get<IEvent[]>(url, {
      headers: this.headers,
      params: queryParams
    });
  }
}
