import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import config from "../../config";
import IStats from "../models/stats";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StatsService {

  headers = new HttpHeaders({'Access-Control-Allow-Origin': config.SERVER_BASE_URL});

  public statsResults: IStats[];

  constructor(private http: HttpClient) { }

  getStats() : Observable<IStats> {
    const url = config.SERVER_BASE_URL + '/stats';
    return this.http.get<IStats>(url, {
      headers: this.headers
    })
  }
}
